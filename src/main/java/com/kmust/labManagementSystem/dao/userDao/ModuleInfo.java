package com.kmust.labManagementSystem.dao.userDao;

public class ModuleInfo {
    private String moduleId;
    private String moduleNm;
    private String note;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleNm() {
        return moduleNm;
    }

    public void setModuleNm(String moduleNm) {
        this.moduleNm = moduleNm;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "moduleId='" + moduleId + '\'' +
                ", moduleNm='" + moduleNm + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
