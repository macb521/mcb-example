package com.example.design.mode.action.cor;
/**
 * @author chunbo.ma.o
 */
public abstract class AbstractLeader {

    public String name;

    protected AbstractLeader successor;

    public AbstractLeader(String name) {
        this.name = name;
    }

    public void setSuccessor(AbstractLeader successor) {
        this.successor = successor;
    }

    /**
     * handleRequest
     * @param leaveNode LeaveNode
     */
    public abstract void handleRequest(LeaveNode leaveNode);

}
