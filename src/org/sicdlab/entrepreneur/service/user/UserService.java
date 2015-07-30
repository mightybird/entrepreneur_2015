package org.sicdlab.entrepreneur.service.user;

import java.util.List;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.beans.Entrepreneur;
import org.sicdlab.entrepreneur.beans.Institution;
import org.sicdlab.entrepreneur.beans.Tutor;
import org.sicdlab.entrepreneur.beans.User;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;

public interface UserService extends BaseService {
	public String registerEntrepreneur(User user, Entrepreneur entrepreneur, String passwordconfirm);

	public String registerTutor(User user, Tutor tutor, String passwordconfirm);

	public String registerInstitution(User user, Institution institution, String passwordconfirm);

	public String checkPassword(User user, String passwordconfirm);

	public List<DataDictionary> getIndustry();

	public String checkLogin(String email, String password);

}
