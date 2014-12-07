
package me.aerovulpe.watportal.resources.courses.schedule;

import java.util.List;

public class WatSchedule{
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
           private Number associated_class;
           private String campus;
           private String catalog_number;
           private Number class_number;
           private List<Classes> classes;
           private Number enrollment_capacity;
           private Number enrollment_total;
           private List<Held_with> held_with;
           private String last_updated;
           private String note;
           private String related_component_1;
           private String related_component_2;
           private List<Reserves> reserves;
           private String section;
           private String subject;
           private Number term;
           private String title;
           private String topic;
           private Number units;
           private Number waiting_capacity;
           private Number waiting_total;

         public String getAcademic_level(){
            return this.academic_level;
        }
        public void setAcademic_level(String academic_level){
            this.academic_level = academic_level;
        }
         public Number getAssociated_class(){
            return this.associated_class;
        }
        public void setAssociated_class(Number associated_class){
            this.associated_class = associated_class;
        }
         public String getCampus(){
            return this.campus;
        }
        public void setCampus(String campus){
            this.campus = campus;
        }
         public String getCatalog_number(){
            return this.catalog_number;
        }
        public void setCatalog_number(String catalog_number){
            this.catalog_number = catalog_number;
        }
         public Number getClass_number(){
            return this.class_number;
        }
        public void setClass_number(Number class_number){
            this.class_number = class_number;
        }
         public List<Classes> getClasses(){
            return this.classes;
        }
        public void setClasses(List<Classes> classes){
            this.classes = classes;
        }
         public Number getEnrollment_capacity(){
            return this.enrollment_capacity;
        }
        public void setEnrollment_capacity(Number enrollment_capacity){
            this.enrollment_capacity = enrollment_capacity;
        }
         public Number getEnrollment_total(){
            return this.enrollment_total;
        }
        public void setEnrollment_total(Number enrollment_total){
            this.enrollment_total = enrollment_total;
        }
         public List<Held_with> getHeld_with(){
            return this.held_with;
        }
        public void setHeld_with(List<Held_with> held_with){
            this.held_with = held_with;
        }
         public String getLast_updated(){
            return this.last_updated;
        }
        public void setLast_updated(String last_updated){
            this.last_updated = last_updated;
        }
         public String getNote(){
            return this.note;
        }
        public void setNote(String note){
            this.note = note;
        }
         public String getRelated_component_1(){
            return this.related_component_1;
        }
        public void setRelated_component_1(String related_component_1){
            this.related_component_1 = related_component_1;
        }
         public String getRelated_component_2(){
            return this.related_component_2;
        }
        public void setRelated_component_2(String related_component_2){
            this.related_component_2 = related_component_2;
        }
         public List<Reserves> getReserves(){
            return this.reserves;
        }
        public void setReserves(List<Reserves> reserves){
            this.reserves = reserves;
        }
         public String getSection(){
            return this.section;
        }
        public void setSection(String section){
            this.section = section;
        }
         public String getSubject(){
            return this.subject;
        }
        public void setSubject(String subject){
            this.subject = subject;
        }
         public Number getTerm(){
            return this.term;
        }
        public void setTerm(Number term){
            this.term = term;
        }
         public String getTitle(){
            return this.title;
        }
        public void setTitle(String title){
            this.title = title;
        }
         public String getTopic(){
            return this.topic;
        }
        public void setTopic(String topic){
            this.topic = topic;
        }
         public Number getUnits(){
            return this.units;
        }
        public void setUnits(Number units){
            this.units = units;
        }
         public Number getWaiting_capacity(){
            return this.waiting_capacity;
        }
        public void setWaiting_capacity(Number waiting_capacity){
            this.waiting_capacity = waiting_capacity;
        }
         public Number getWaiting_total(){
            return this.waiting_total;
        }
        public void setWaiting_total(Number waiting_total){
            this.waiting_total = waiting_total;
        }
    }
}
