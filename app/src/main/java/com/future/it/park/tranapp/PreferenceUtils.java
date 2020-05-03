package com.future.it.park.tranapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {

	public static void setUserName (Context context, String email){
		getSharedPreferences(context).edit().putString("USERNAME", email).commit();
	}

	public static String getUserName(Context context) {
		return getSharedPreferences(context).getString("USERNAME", "");
	}

	public static void setFather (Context context, String email){
		getSharedPreferences(context).edit().putString("Father", email).commit();
	}

	public static String getFather(Context context) {
		return getSharedPreferences(context).getString("Father", "");
	}

	public static void setMother (Context context, String email){
		getSharedPreferences(context).edit().putString("Mother", email).commit();
	}

	public static String getMother (Context context) {
		return getSharedPreferences(context).getString("Mother", "");
	}

	public static void setMobile (Context context, String email){
		getSharedPreferences(context).edit().putString("Mobile", email).commit();
	}

	public static String getMobile (Context context) {
		return getSharedPreferences(context).getString("Mobile", "");
	}

	public static void setNationalId (Context context, String email){
		getSharedPreferences(context).edit().putString("National_id", email).commit();
	}

	public static String getNationalId (Context context) {
		return getSharedPreferences(context).getString("National_id", "");
	}

	public static void setOccupation (Context context, String email){
		getSharedPreferences(context).edit().putString("Occupation", email).commit();
	}

	public static String getOccupation (Context context) {
		return getSharedPreferences(context).getString("Occupation", "");
	}

	public static void setFamilyMember (Context context, String email){
		getSharedPreferences(context).edit().putString("FamilyMemeber", email).commit();
	}

	public static String getFamilyMember (Context context) {
		return getSharedPreferences(context).getString("FamilyMemeber", "");
	}

	public static void setMonthlyIncome (Context context, String email){
		getSharedPreferences(context).edit().putString("MonthlyIncome", email).commit();
	}

	public static String getMonthlyIncome (Context context) {
		return getSharedPreferences(context).getString("MonthlyIncome", "");
	}

	public static void setJela (Context context, String email){
		getSharedPreferences(context).edit().putString("Jela", email).commit();
	}

	public static String getJela (Context context) {
		return getSharedPreferences(context).getString("Jela", "");
	}

	public static void setUpoJela (Context context, String email){
		getSharedPreferences(context).edit().putString("UpoJela", email).commit();
	}

	public static String getUpoJela (Context context) {
		return getSharedPreferences(context).getString("UpoJela", "");
	}

	public static void setWord (Context context, String email){
		getSharedPreferences(context).edit().putString("Word", email).commit();
	}

	public static String getWord (Context context) {
		return getSharedPreferences(context).getString("Word", "");
	}

	public static void setVillage (Context context, String email){
		getSharedPreferences(context).edit().putString("setVillage", email).commit();
	}

	public static String getVillage (Context context) {
		return getSharedPreferences(context).getString("setVillage", "");
	}

	public static void setHouseNo (Context context, String email){
		getSharedPreferences(context).edit().putString("setHouseNo", email).commit();
	}

	public static String getHouseNo (Context context) {
		return getSharedPreferences(context).getString("setHouseNo", "");
	}

	public static void setEasyWay (Context context, String email){
		getSharedPreferences(context).edit().putString("setEasyWay", email).commit();
	}

	public static String getEasyWay (Context context) {
		return getSharedPreferences(context).getString("setEasyWay", "");
	}

	public static void setComment (Context context, String email){
		getSharedPreferences(context).edit().putString("setComment", email).commit();
	}

	public static String getComment (Context context) {
		return getSharedPreferences(context).getString("setComment", "");
	}

	public static void setSupportName (Context context, String email){
		getSharedPreferences(context).edit().putString("SupportName", email).commit();
	}

	public static String getSupportName (Context context) {
		return getSharedPreferences(context).getString("SupportName", "");
	}

	public static void setSupportPassword (Context context, String email){
		getSharedPreferences(context).edit().putString("SupportPass", email).commit();
	}

	public static String getSupportPassword (Context context) {
		return getSharedPreferences(context).getString("SupportPass", "");
	}

	public static void setSupportId (Context context, String email){
		getSharedPreferences(context).edit().putString("SupportId", email).commit();
	}

	public static String getSupportId (Context context) {
		return getSharedPreferences(context).getString("SupportId", "");
	}

	public static void setPermanentAddress (Context context, String email){
		getSharedPreferences(context).edit().putString("setPermanentAddress", email).commit();
	}

	public static String getPermanentAddress (Context context) {
		return getSharedPreferences(context).getString("setPermanentAddress", "");
	}


	public static String getIP(Context context) {
		//return getSharedPreferences(context).getString("getip", "http://doortodoorkhulna.com/admin/api/");
		return getSharedPreferences(context).getString("getip", "http://10.0.2.2:8000/api/");
	}

	public static SharedPreferences getSharedPreferences(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}



}