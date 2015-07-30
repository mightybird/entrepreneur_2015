package org.sicdlab.entrepreneur.service.projectservice;

import java.util.List;

import org.sicdlab.entrepreneur.beans.DataDictionary;
import org.sicdlab.entrepreneur.service.baseservice.BaseService;

public interface ProjectService  extends BaseService{
	List<DataDictionary> getFundScope();
	List<DataDictionary> getFundType();
	List<DataDictionary> getFundLack();
}
