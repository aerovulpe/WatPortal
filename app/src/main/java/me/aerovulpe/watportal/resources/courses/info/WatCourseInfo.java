
package me.aerovulpe.watportal.resources.courses.info;

import java.util.List;

public class WatCourseInfo{
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
           private String academic_level;
           private String antirequisites;
           private String calendar_year;
           private String catalog_number;
           private String corequisites;
           private String course_id;
           private String crosslistings;
           private String description;
           private List<Extra> extra;
           private List<Instructions> instructions;
           private boolean needs_department_consent;
           private boolean needs_instructor_consent;
           private String notes;
           private Offerings offerings;
           private String prerequisites;
           private String subject;
           private List<Terms_offered> terms_offered;
           private String title;
           private Number units;
           private String url;

         public String getAcademic_level(){
            return this.academic_level;
        }
        public void setAcademic_level(String academic_level){
            this.academic_level = academic_level;
        }
         public String getAntirequisites(){
            return this.antirequisites;
        }
        public void setAntirequisites(String antirequisites){
            this.antirequisites = antirequisites;
        }
         public String getCalendar_year(){
            return this.calendar_year;
        }
        public void setCalendar_year(String calendar_year){
            this.calendar_year = calendar_year;
        }
         public String getCatalog_number(){
            return this.catalog_number;
        }
        public void setCatalog_number(String catalog_number){
            this.catalog_number = catalog_number;
        }
         public String getCorequisites(){
            return this.corequisites;
        }
        public void setCorequisites(String corequisites){
            this.corequisites = corequisites;
        }
         public String getCourse_id(){
            return this.course_id;
        }
        public void setCourse_id(String course_id){
            this.course_id = course_id;
        }
         public String getCrosslistings(){
            return this.crosslistings;
        }
        public void setCrosslistings(String crosslistings){
            this.crosslistings = crosslistings;
        }
         public String getDescription(){
            return this.description;
        }
        public void setDescription(String description){
            this.description = description;
        }
         public List<Extra> getExtra(){
            return this.extra;
        }
        public void setExtra(List<Extra> extra){
            this.extra = extra;
        }
         public List<Instructions> getInstructions(){
            return this.instructions;
        }
        public void setInstructions(List<Instructions> instructions){
            this.instructions = instructions;
        }
         public boolean getNeeds_department_consent(){
            return this.needs_department_consent;
        }
        public void setNeeds_department_consent(boolean needs_department_consent){
            this.needs_department_consent = needs_department_consent;
        }
         public boolean getNeeds_instructor_consent(){
            return this.needs_instructor_consent;
        }
        public void setNeeds_instructor_consent(boolean needs_instructor_consent){
            this.needs_instructor_consent = needs_instructor_consent;
        }
         public String getNotes(){
            return this.notes;
        }
        public void setNotes(String notes){
            this.notes = notes;
        }
         public Offerings getOfferings(){
            return this.offerings;
        }
        public void setOfferings(Offerings offerings){
            this.offerings = offerings;
        }
         public String getPrerequisites(){
            return this.prerequisites;
        }
        public void setPrerequisites(String prerequisites){
            this.prerequisites = prerequisites;
        }
         public String getSubject(){
            return this.subject;
        }
        public void setSubject(String subject){
            this.subject = subject;
        }
         public List<Terms_offered> getTerms_offered(){
            return this.terms_offered;
        }
        public void setTerms_offered(List<Terms_offered> terms_offered){
            this.terms_offered = terms_offered;
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
         public String getUrl(){
            return this.url;
        }
        public void setUrl(String url){
            this.url = url;
        }
    }
}
