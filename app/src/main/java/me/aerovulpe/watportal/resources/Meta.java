
package me.aerovulpe.watportal.resources;

public class Meta{
   	private String message;
   	private int method_id;
   	private int requests;
   	private int status;
   	private int timestamp;

 	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
 	public int getMethod_id(){
		return this.method_id;
	}
	public void setMethod_id(int method_id){
		this.method_id = method_id;
	}
 	public int getRequests(){
		return this.requests;
	}
	public void setRequests(int requests){
		this.requests = requests;
	}
 	public int getStatus(){
		return this.status;
	}
	public void setStatus(int status){
		this.status = status;
	}
 	public int getTimestamp(){
		return this.timestamp;
	}
	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}
}
