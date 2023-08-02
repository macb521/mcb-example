package com.example.design.mode.action.cor;
/**
 * @author chunbo.ma.o
 */
public class Dean extends AbstractLeader {

    public static final int INT = 10;

    public Dean(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        //小于10天院长审批
        if (leaveNode.getNumber() <= INT) {
            System.out.println("院长" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else if (this.successor != null) {
            this.successor.handleRequest(leaveNode);
        }

    }

}