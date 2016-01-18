package ac.mmu.mmu_ac_assignment;

import java.util.ArrayList;
import java.util.Collection;

public interface Staff {
	 public void addStaff (StaffMember sinfo);
	 public ArrayList listStaff();
	 public Collection searchStaff(String searchStr);
	}