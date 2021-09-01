package com.night.user.sms.interfaces.assembler;

@FunctionalInterface
public interface Assembler<S, T> {

    /**
     * 装配 请实现装配过程
     *
     * @param source 源
     * @param target 目标
     */
    void assemble(S source, T target);

}