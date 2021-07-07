package com.solidworks.notekeeper;

import android.os.Parcel;
import android.os.Parcelable;

public final class NoteInfo implements Parcelable {
    private CourseInfo mCourse;
    private String mTitle;
    private String mText;

    public NoteInfo(CourseInfo course, String title, String text) {
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    private NoteInfo(Parcel parcel) {
        mCourse = parcel.readParcelable(CourseInfo.class.getClassLoader());
        mTitle = parcel.readString();
        mText = parcel.readString();
    }

    public CourseInfo getCourse() {
        return mCourse;
    }

    public void setCourse(CourseInfo course) {
        mCourse = course;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mCourse.getCourseId() + "|" + mTitle + "|" + mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        com.solidworks.notekeeper.NoteInfo that = (com.solidworks.notekeeper.NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(mCourse, 0);
        parcel.writeString(mTitle);
        parcel.writeString(mText);
    }

    public static final Creator<com.solidworks.notekeeper.NoteInfo> CREATOR =
            new Creator<com.solidworks.notekeeper.NoteInfo>() {
                @Override
                public com.solidworks.notekeeper.NoteInfo createFromParcel(Parcel parcel) {
                    return new com.solidworks.notekeeper.NoteInfo(parcel);
                }

                @Override
                public com.solidworks.notekeeper.NoteInfo[] newArray(int size) {
                    return new com.solidworks.notekeeper.NoteInfo[size];
                }
            };
}












