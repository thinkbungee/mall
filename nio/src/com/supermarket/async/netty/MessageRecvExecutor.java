package com.supermarket.async.netty;

import com.supermarket.async.ServiceThreadPool;
import com.supermarket.async.model.MessageRequest;
import com.supermarket.async.model.MessageResponse;
import com.supermarket.core.NioSystemConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MessageRecvExecutor {
    private  String serverAddress;
    private static int queueNums = NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_QUEUE_NUMS;
    private static int threadNums = NioSystemConfig.SYSTEM_PROPERTY_THREADPOOL_THREAD_NUMS;
    private static volatile ExecutorService threadPoolExecutor;

    private static class MessageRecvExecutorHolder{
        static final MessageRecvExecutor INSTANCE = new MessageRecvExecutor();
    }

    public static MessageRecvExecutor getInstance(){
        return MessageRecvExecutorHolder.INSTANCE;
    }

    public static void submit(Callable<Boolean> task, final ChannelHandlerContext ctx, final MessageRequest request, final MessageResponse response){
        if (threadPoolExecutor == null) {
            synchronized (MessageRecvExecutor.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = (ExecutorService)ServiceThreadPool.getExecutor(threadNums, queueNums);
                }
            }
        }
        Future<Boolean> future = threadPoolExecutor.submit(task);
        try {
            Boolean isSuccess = future.get();
            if (isSuccess){
                ctx.writeAndFlush(response).addListener(new ChannelFutureListener(){

                    @Override
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        System.out.println("nio Server Send message-id respone:" + request.getMessageId());
                    }
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
