package org.sicdlab.entrepreneur.service.projectservice;

import java.util.List;
import java.util.Set;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Label;
import org.sicdlab.entrepreneur.beans.Project;
import org.sicdlab.entrepreneur.beans.ProjectInstitution;
import org.sicdlab.entrepreneur.beans.Resource;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;

public interface ProjectService  extends BaseService{
	List<DataDictionary> getFundScope();
	List<DataDictionary> getFundType();
	List<DataDictionary> getFundLack();
	boolean SaveProjectImagePath(String ownid,String resourceType,String path);
	Entrepreneur getEntrepreneruById(String UserId);
	User getUserById(String userid);
	Institution getInstitutionById(String userid);
	ProjectInstitution getPIByProjectAndInstitution(Project p,Institution i);
	Project getProjectById(String projectid);
	Resource getResourceByOwnid(String ownid);
	Label FindLabelByName(String name);
	List<String> getLabelsByProjectId(String id);
}
