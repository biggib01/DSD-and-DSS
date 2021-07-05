public class JDBC {
    private int age,fnlwgt,education_num,capital_gain,capital_loss,hours_per_week;
    private String workClass,education,marital_status,occupation,income,
            relationship,race,sex,native_country;

    public JDBC(
        int age, String workClass, int fnlwgt, String education, int education_num,
        String marital_status, String occupation, String relationship, String race,
        String sex, int capital_gain, int caption_loss, int hours_per_week,
        String native_country,String income
    ){
           
        this.age = age;
        this.fnlwgt = fnlwgt;
        this.education_num = education_num;
        this.capital_gain = capital_gain;
        this.capital_loss = caption_loss;
        this.hours_per_week = hours_per_week;
        this.workClass = workClass;
        this.education = education;
        this.marital_status = marital_status;
        this.occupation = occupation;
        this.relationship = relationship;
        this.race = race;
        this.sex = sex;
        this.native_country = native_country;
        this.income = income;
    }

    public int getAge(){
        return age;
    }

    public int getFnlwgt(){
        return fnlwgt;
    }

    public String getWorkClass(){
        return workClass;
    }

    public String getEducation(){
        return education;
    }

    public int getEducation_num(){
        return education_num;
    }

    public String getMarital_status(){
        return marital_status;
    }

    public String getOccupation(){
        return occupation;
    }

    public String getRelationShip(){
        return relationship;
    }

    public String getRace(){
        return race;
    }

    public String getSex(){
        return sex;
    }

    public int getCapital_gain(){
        return capital_gain;
    }

    public int getCapital_loss(){
        return capital_loss;
    }

    public int getHours_per_week(){
        return hours_per_week;
    }

    public String getNative_country(){
        return native_country;
    }

    public String getIncome(){
        return income;
    }

    @Override
    public String toString(){
        return "("+age+","+"'"+workClass+"'"+","+fnlwgt+","+"'"+education+"'"+","+
        education_num+","+"'"+marital_status+"'"+","+"'"+occupation+"'"+","+
        "'"+relationship+"'"+","+race+"'"+","+"'"+sex+"'"+","+capital_gain+","+
        capital_loss+","+hours_per_week+","+"'"+native_country+"'"+","+"'"+income+"'"+")"
        ;
    }
}
