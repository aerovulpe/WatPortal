
package me.aerovulpe.watportal.resources.courses.subject;

import java.util.List;

public class WatSubject{
   	private List<Data> data;
   	private Meta meta;

 	public List<Data> getData(){
		return this.data;
	}
	public void setData(List<Data> data){
		this.data = data;
	}
 	public Meta getMeta(){
		return this.meta;
	}
	public void setMeta(Meta meta){
		this.meta = meta;
	}

    public static class Data{
           private String academic_level;
           private String catalog_number;
           private String course_id;
           private String description;
           private String subject;
           private String title;
           private Number units;

         public String getAcademic_level(){
            return this.academic_level;
        }
        public void setAcademic_level(String academic_level){
            this.academic_level = academic_level;
        }
         public String getCatalog_number(){
            return this.catalog_number;
        }
        public void setCatalog_number(String catalog_number){
            this.catalog_number = catalog_number;
        }
         public String getCourse_id(){
            return this.course_id;
        }
        public void setCourse_id(String course_id){
            this.course_id = course_id;
        }
         public String getDescription(){
            return this.description;
        }
        public void setDescription(String description){
            this.description = description;
        }
         public String getSubject(){
            return this.subject;
        }
        public void setSubject(String subject){
            this.subject = subject;
        }
         public String getTitle(){
            return this.title;
        }
        public void setTitle(String title){
            this.title = title;
        }
         public Number getUnits(){
            return this.units;
        }
        public void setUnits(Number units){
            this.units = units;
        }
    }
}
