package com.bestbpf.d1;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {

    public static void main(String[] args) {
        // 堆内存 class java.nio.HeapByteBuffer
        // 读写效率较低 收到GC影响
        ByteBuffer heapBuffer = ByteBuffer.allocate(10);
        System.out.println(heapBuffer.getClass());
        // 直接内存 class java.nio.DirectByteBuffer
        // 读写效率高，少一次数据拷贝
        // 分配内存效率低，使用不当内存泄漏
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10);
        System.out.println(directBuffer.getClass());
    }
}
