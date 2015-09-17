package domain;

import java.util.List;

public class Page {

	private List list;
	
	private int startindex;
	private int pagesize=5;
	
	private int pagenum;
	private int totalrecord;
	
	private int totalpage;
	private int startnum;
	private int endnum;
	
	public Page(int pagenum,int totalrecord){
		this.pagenum=pagenum;
		this.totalrecord=totalrecord;
		startindex = (pagenum-1)*pagesize;
		if(totalrecord % pagesize==0){
			totalpage = totalrecord/pagesize;
		}else{
			totalpage = totalrecord/pagesize+1;
		}
		if(totalpage<=5){
			startnum = 1;
			endnum = totalpage;
		}else{
			startnum = pagenum - 2;
			endnum = pagenum + 2;
			if(startnum<1){
				startnum = 1;
				endnum=5;
			}
			if(endnum>totalpage){
				endnum=totalpage;
				startnum=totalpage-4;
			}
			
		}
		
		
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getStartnum() {
		return startnum;
	}

	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}
	
	
	
}
