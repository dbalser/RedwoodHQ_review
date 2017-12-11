package CSPSSP;

class SetAutoHostingGroup{
	public String run(def params){
        if (params.get("cspEnvironment").toString()=='QA'){
        return "AWS-AUTO"
        }
        else{
        return "AWS_AUTO"
        }
    }
}