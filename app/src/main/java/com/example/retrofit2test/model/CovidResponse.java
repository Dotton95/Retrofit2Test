package com.example.retrofit2test.model;

import android.media.MediaDrm;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Response;

public class CovidResponse {
    @SerializedName("response")
    private Response response;

    public class Response{
        @SerializedName("header")
        private Header header;

        @SerializedName("body")
        private Body body;

        public Body getBody() { return body; }

        public Header getHeader() { return header; }
    }
    public class Header{
        @SerializedName("resultCode")
        private String resultCode;

        @SerializedName("resultMsg")
        private String resultMsg;

        public String getResultCode() { return resultCode; }

        public String getResultMsg() { return resultMsg; }
    }
    public class Body{
        @SerializedName("items")
        private Items items;

        @SerializedName("totalCount")
        private int totalCount;
        @SerializedName("pageNo")
        private int pageNo;
        @SerializedName("numOfRows")
        private int numOfRows;

        public int getNumOfRows() { return numOfRows; }
        public int getPageNo() { return pageNo; }
        public int getTotalCount() { return totalCount; }
        public Items getItems() { return items; }
    }
    public class Items{
        @SerializedName("item")
        private List<Item> item;

        public List<Item> getItem() { return item; }
    }
    public class Item{
        //게시글번호
        @SerializedName("seq")
        private String seq;
        //기준일
        @SerializedName("stateDt")
        private String stateDt;
        //기준시간
        @SerializedName("statTime")
        private String stateTime;
        //확진자 수
        @SerializedName("decideCnt")
        private String decideCnt;
        //사망자 수
        @SerializedName("deathCnt")
        private String deathCnt;
        //누적 의심 신고 검사자
        @SerializedName("accExamCnt")
        private String accExamCnt;
        //누적 확진률
        @SerializedName("accDefRate")
        private String accDefRate;
        //등록일시
        @SerializedName("createDt")
        private String createDt;
        //수정일시
        @SerializedName("updateDt")
        private String updateDt;

        public String getSeq() { return seq; }
        public String getStateDt() { return stateDt; }
        public String getStateTime() { return stateTime; }
        public String getDecideCnt() { return decideCnt; }
        public String getDeathCnt() { return deathCnt; }
        public String getAccExamCnt() { return accExamCnt; }
        public String getAccDefRate() { return accDefRate; }
        public String getCreateDt() { return createDt; }
        public String getUpdateDt() { return updateDt; }
    }
}
