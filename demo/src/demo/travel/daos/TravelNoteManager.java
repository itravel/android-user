package demo.travel.daos;

import java.util.Date;
import java.util.List;

import com.itravel.server.interfaces.dal.ITravelNote;
import com.itravel.server.interfaces.dal.managers.ITravelNoteManager;

import demo.travel.models.TravelNote;
/**
 * 
 * @author william.wangwm
 *	
 */
// TODO to be single pattern.
public class TravelNoteManager implements ITravelNoteManager {

	@Override
	public ITravelNote create() {
		// TODO Auto-generated method stub
		return new TravelNote();
	}

	@Override
	public ITravelNote create(String json) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public ITravelNote get(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ITravelNote> getRange(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(ITravelNote arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(ITravelNote arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ITravelNote> getByTimeRange(Date arg0, Date arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
