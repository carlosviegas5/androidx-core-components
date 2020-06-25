package org.ros.android.android_tutorial_pubsub;

import org.apache.commons.logging.Log;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.AbstractNodeMain;
import org.ros.node.ConnectedNode;
import org.ros.node.topic.Subscriber;

import std_msgs.String;

public class MyListener extends AbstractNodeMain {

    public MyListener() {
    }

    public GraphName getDefaultNodeName() {
        return GraphName.of("rosjava_tutorial_pubsub/listener");
    }

    public void onStart(ConnectedNode connectedNode) {
        final Log log = connectedNode.getLog();
        Subscriber<String> subscriber = connectedNode.newSubscriber("test", "std_msgs/String");
        subscriber.addMessageListener(new MessageListener<String>() {
            public void onNewMessage(String message) {
                System.out.println("bish"+message.getData());
                log.info("I heard: \"" + message.getData() + "\"");
            }
        });
    }

}
