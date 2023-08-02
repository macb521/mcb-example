package com.example.design.mode.action.cor;
/**
 * @author chunbo.ma.o
 */
public class Instructor extends AbstractLeader {

    public static final int INT = 3;

    public Instructor(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        if (leaveNode.getNumber() <= INT) {

            System.out.println("辅导员" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else if (this.successor != null) {
            this.successor.handleRequest(leaveNode);
        }
    }
}
