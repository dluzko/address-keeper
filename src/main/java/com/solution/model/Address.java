package com.solution.model;

import java.time.LocalDate;

public class Address {
    private int id;
    private int objectId;
    private String objectGuid;
    private String changeId;
    private String name;
    private String typeName;
    private int level;
    private int operTypeId;
    private int prevId;
    private int nextId;
    private LocalDate updateDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private int isActual;
    private int isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectGuid() {
        return objectGuid;
    }

    public void setObjectGuid(String objectGuid) {
        this.objectGuid = objectGuid;
    }

    public String getChangeId() {
        return changeId;
    }

    public void setChangeId(String changeId) {
        this.changeId = changeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOperTypeId() {
        return operTypeId;
    }

    public void setOperTypeId(int operTypeId) {
        this.operTypeId = operTypeId;
    }

    public int getPrevId() {
        return prevId;
    }

    public void setPrevId(int prevId) {
        this.prevId = prevId;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getIsActual() {
        return isActual;
    }

    public void setIsActual(int isActual) {
        this.isActual = isActual;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", objectGuid='" + objectGuid + '\'' +
                ", changeId='" + changeId + '\'' +
                ", name='" + name + '\'' +
                ", typeName='" + typeName + '\'' +
                ", level=" + level +
                ", operTypeId=" + operTypeId +
                ", prevId=" + prevId +
                ", nextId=" + nextId +
                ", updateDate=" + updateDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isActual=" + isActual +
                ", isActive=" + isActive +
                '}';
    }
}
