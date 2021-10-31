package transport.nettyTransport.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import test.Test;

/**
 * @Author: Mercer JR
 * @Date: 2021/10/29 22:19
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decoder",new ProtobufDecoder(Test.Person.getDefaultInstance()));
        pipeline.addLast("encoder",new ProtobufEncoder());
        pipeline.addLast(new ServerHandler());
    }
}
