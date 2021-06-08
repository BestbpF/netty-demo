package com.bestbpf.d1;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class TestByteBuffer {

    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            // 缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从channel读取数据，写到buffer
            while (channel.read(buffer) != -1) {
                // 打印buffer
                buffer.flip(); //切换到读模式
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.debug("读取到的字符{}", (char) b);
                }
                buffer.clear(); //切换到写模式
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
