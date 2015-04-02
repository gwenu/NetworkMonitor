package ag.networkmonitor.models;

import java.util.Date;

public class SystemProcess {
	
	private int pid;
	private String user;
	private double cpu;
	private double mem;
	private int vsz;
	private int rrs;
	private String tty; //Possibly should be Enum
	private String stat; //Possibly should be Enum 
	private Date start;
	private Date time;
	private String command;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getCpu() {
		return cpu;
	}
	public void setCpu(double cpu) {
		this.cpu = cpu;
	}
	public double getMem() {
		return mem;
	}
	public void setMem(double mem) {
		this.mem = mem;
	}
	public int getVsz() {
		return vsz;
	}
	public void setVsz(int vsz) {
		this.vsz = vsz;
	}
	public int getRrs() {
		return rrs;
	}
	public void setRrs(int rrs) {
		this.rrs = rrs;
	}
	public String getTty() {
		return tty;
	}
	public void setTty(String tty) {
		this.tty = tty;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
