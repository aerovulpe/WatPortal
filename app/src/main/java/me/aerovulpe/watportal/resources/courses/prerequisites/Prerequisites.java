package me.aerovulpe.watportal.resources.courses.prerequisites;

import java.util.List;

/**
 * Created by Aaron on 11/12/2014.
 */
public class Prerequisites {
    private int numOfPrerequisites;
    private List<String> prerequisitesOptions;

    public int getNumOfPrerequisites() {
        return numOfPrerequisites;
    }

    public void setNumOfPrerequisites(int numOfPrerequisites) {
        this.numOfPrerequisites = numOfPrerequisites;
    }

    public List<String> getPrerequisitesOptions() {
        return prerequisitesOptions;
    }

    public void setPrerequisitesOptions(List<String> prerequisitesOptions) {
        this.prerequisitesOptions = prerequisitesOptions;
    }
}
