package ag.processmonitor.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemProcess {
	
	private long pid;		//Process identifier
	private String user;
	private double cpu;		// Central processing unit
	private double mem;     // Ratio of the process’s resident set size to the physical memory on the machine
	private int vsz;		// Virtual Memory Size. It includes all memory that the process can access, including memory that is swapped out and memory that is from shared libraries.
	private int rss;		// Resident Set Size and is used to show how much memory is allocated to that process and is in RAM. It does not include memory that is swapped out. 
	private String tty; 	// Teletype Possibly -> Possibly should be Enum
	private String stat; 	// Possibly should be Enum 
	private Date start;
	private Date time;
	private String command;
	
	public long getPid() {
		return pid;
	}

	public String getUser() {
		return user;
	}

	public double getCpu() {
		return cpu;
	}

	public double getMem() {
		return mem;
	}

	public int getVsz() {
		return vsz;
	}

	public int getRss() {
		return rss;
	}

	public String getTty() {
		return tty;
	}

	public String getStat() {
		return stat;
	}

	public Date getStart() {
		return start;
	}

	public Date getTime() {
		return time;
	}

	public String getCommand() {
		return command;
	}
	
	@Override
	public String toString() {
		DateFormat timeFormater = new SimpleDateFormat("HH:mm");
		StringBuilder sb = new StringBuilder();
		sb.append("ag.processmonitor.models.SystemProcess ");
		sb.append("[user = " + user + "]");
		sb.append("[pid = " + pid + "]");
		sb.append("[cpu = " + cpu + "]");
		sb.append("[mem = " + mem + "]");
		sb.append("[vsz = " + vsz + "]");
		sb.append("[rss = " + rss + "]");
		sb.append("[tty = " + tty + "]");
		sb.append("[stat = " + stat + "]");
		sb.append("[start = " + timeFormater.format(start) + "]");
		sb.append("[time = " + timeFormater.format(time) + "]");
		sb.append("[command = " + command + "]");
		return sb.toString();
	}
	
	public static class Builder {
		private long pid;
		private String user;
		private double cpu;	
		private double mem;
		private int vsz;
		private int rss;
		private String tty;
		private String stat;
		private Date start;
		private Date time;
		private String command;
		
		public Builder pid(long pid) {
			this.pid = pid;
			return this;
		}
		
		public Builder user(String user) {
			this.user = user;
			return this;
		}
		
		public Builder cpu(double cpu) {
			this.cpu = cpu;
			return this;
		}
		
		public Builder mem(double mem) {
			this.mem = mem;
			return this;
		}
		
		public Builder vsz(int vsz) {
			this.vsz = vsz;
			return this;
		}
		
		public Builder rss(int rss) {
			this.rss = rss;
			return this;
		}
		
		public Builder tty(String tty) {
			this.tty = tty;
			return this;
		}
		public Builder stat(String stat) {
			this.stat = stat;
			return this;
		}
		
		public Builder start(Date start) {
			this.start = start;
			return this;
		}
		
		public Builder time(Date time) {
			this.time = time;
			return this;
		}
		
		public Builder command(String command) {
			this.command = command;
			return this;
		}
		
		public SystemProcess build() {
			return new SystemProcess(this);
		}
	}
	
	private SystemProcess(Builder builder) {
		this.pid = builder.pid;	
		this.user = builder.user;
		this.cpu = builder.cpu;	
		this.mem = builder.mem;
		this.vsz = builder.vsz;
		this.rss = builder.rss;
		this.tty = builder.tty;
		this.stat = builder.stat;
		this.start = builder.start;
		this.time = builder.time;
		this.command = builder.command;
	}
}
