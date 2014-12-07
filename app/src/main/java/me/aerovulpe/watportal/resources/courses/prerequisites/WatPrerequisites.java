
package me.aerovulpe.watportal.resources.courses.prerequisites;

import java.util.List;

public class WatPrerequisites{
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
           private String catalog_number;
           private String prerequisites;
           private List<Prerequisites_parsed> prerequisites_parsed;
           private String subject;
           private String title;

         public String getCatalog_number(){
            return this.catalog_number;
        }
        public void setCatalog_number(String catalog_number){
            this.catalog_number = catalog_number;
        }
         public String getPrerequisites(){
            return this.prerequisites;
        }
        public void setPrerequisites(String prerequisites){
            this.prerequisites = prerequisites;
        }
         public List<Prerequisites_parsed> getPrerequisites_parsed(){
            return this.prerequisites_parsed;
        }
        public void setPrerequisites_parsed(List<Prerequisites_parsed> prerequisites_parsed){
            this.prerequisites_parsed = prerequisites_parsed;
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
    }
}
