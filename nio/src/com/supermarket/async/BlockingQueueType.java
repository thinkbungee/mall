package com.supermarket.async;

/**
 * @filename:BlockingQueueType.java
 *
 *
 * @Description:队列枚举
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public enum BlockingQueueType {

    /**
     * @param LINKED_BLOCKING_QUEUE  链表有界阻塞队列(FIFO)
     * @param ARRAY_BLOCKING_QUEUE   数组有界阻塞队列(FIFO)
     * @param SYNCHRONOUS_QUEUE      无缓存阻塞队列
     */
    LINKED_BLOCKING_QUEUE("LinkedBlockingQueue"),
    ARRAY_BLOCKING_QUEUE("ArrayBlockingQueue"),
    SYNCHRONOUS_QUEUE("SynchronousQueue");

    private String value;

    BlockingQueueType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static BlockingQueueType fromString(String value){
        for (BlockingQueueType qType : BlockingQueueType.values()) {
            if (qType.getValue().equalsIgnoreCase(value)) {
                return qType;
            }
        }
        throw new IllegalArgumentException("not found value="+value);
    }

    @Override
    public String toString() {
        return "BlockingQueueType{" +
                "value='" + value + '\'' +
                '}';
    }
}
