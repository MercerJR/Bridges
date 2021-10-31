package transport.nettyTransport.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import test.Test;

/**
 * @Author: Mercer JR
 * @Date: 2021/10/29 22:46
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("encoder",new ProtobufEncoder());
        pipeline.addLast("decoder",new ProtobufDecoder(Test.Person.getDefaultInstance()));
        pipeline.addLast(new ClientHandler());
    }
}
