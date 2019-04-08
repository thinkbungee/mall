package com.supermarket.async.policy;

/**
 * @filename:RejectedPolicyType.java
 *
 *
 * @Description:拒绝策略枚举
 * @author dzh
 * @date 2019.03.28
 * @version 1.0
 */
public enum RejectedPolicyType {
    /**
     * @param ABORT_POLICY          丢弃任务并抛出异常
     * @param BLOCKING_POLICY       等待队列有可用空间再加入任务
     * @param CALLER_RUNS_POLICY    由主线程执行该任务
     * @param DISCARDED_POLICY      丢弃最早的几个任务,立即添加任务
     * @param REJECTED_POLICY       丢弃最早的几个任务,RejectedRunnable线程直接丢弃
     */
    ABORT_POLICY("AbortPolicy"),
    BLOCKING_POLICY("BlockingPolicy"),
    CALLER_RUNS_POLICY("CallerRunsPolicy"),
    DISCARDED_POLICY("DiscardedPolicy"),
    REJECTED_POLICY("RejectedPolicy");

    private String value;

    RejectedPolicyType(String value){
        this.value = value;
    }

    public static RejectedPolicyType fromString(String value){
        for (RejectedPolicyType pType : RejectedPolicyType.values()){
            if (pType.value.equalsIgnoreCase(value)) {
                return pType;
            }
        }
        throw  new IllegalArgumentException("not found value="+value);
    }

    @Override
    public String toString() {
        return "RejectedPolicyType{" +
                "value='" + value + '\'' +
                '}';
    }
}
