
package me.aerovulpe.watportal.resources.courses.examschedule;

import java.util.List;

public class WatExamSchedule{
   	private Data data;
   	private Meta meta;

 	public Data getData(){
		return this.data;
	}
	public void setData(Data data){
		this.data = data;
	}
 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}

    public static class Data{
           private String course;
           private List<Sections> sections;

         public String getCourse(){
            return this.course;
        }
        public void setCourse(String course){
            this.course = course;
        }
         public List<Sections> getSections(){
            return this.sections;
        }
        public void setSections(List<Sections> sections){
            this.sections = sections;
        }
    }
}
