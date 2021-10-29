package transport.nettyTransport.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Author: Mercer JR
 * @Date: 2021/10/29 22:54
 */
public class ClientStart {

    public static void initClient(String hostname,int port){
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ClientChannelInitializer());
        try {
            ChannelFuture channelFuture = bootstrap.connect(hostname, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
