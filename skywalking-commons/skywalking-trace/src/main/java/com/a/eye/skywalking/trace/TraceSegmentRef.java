package com.a.eye.skywalking.trace;

import com.a.eye.skywalking.trace.tag.Tags;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * {@link TraceSegmentRef} is like a pointer, which ref to another {@link TraceSegment},
 * use {@link #spanId} point to the exact span of the ref {@link TraceSegment}.
 *
 * Created by wusheng on 2017/2/17.
 */
public class TraceSegmentRef{
    /**
     * {@link TraceSegment#traceSegmentId}
     */
    @Expose
    @SerializedName(value="ts")
    private String traceSegmentId;

    /**
     * {@link Span#spanId}
     */
    @Expose
    @SerializedName(value="si")
    private int spanId = -1;

    /**
     * {@link TraceSegment#applicationCode}
     */
    @Expose
    @SerializedName(value="ac")
    private String applicationCode;

    /**
     * {@link Tags#PEER_HOST}
     */
    @Expose
    @SerializedName(value="ph")
    private String peerHost;

    /**
     * Create a {@link TraceSegmentRef} instance, without any data.
     */
    public TraceSegmentRef() {
    }

    public String getTraceSegmentId() {
        return traceSegmentId;
    }

    public void setTraceSegmentId(String traceSegmentId) {
        this.traceSegmentId = traceSegmentId;
    }

    public int getSpanId() {
        return spanId;
    }

    public void setSpanId(int spanId) {
        this.spanId = spanId;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getPeerHost() {
        return peerHost;
    }

    public void setPeerHost(String peerHost) {
        this.peerHost = peerHost;
    }

    @Override public String toString() {
        return "TraceSegmentRef{" +
            "traceSegmentId='" + traceSegmentId + '\'' +
            ", spanId=" + spanId +
            ", applicationCode='" + applicationCode + '\'' +
            ", peerHost='" + peerHost + '\'' +
            '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TraceSegmentRef ref = (TraceSegmentRef)o;

        if (traceSegmentId != null ? !traceSegmentId.equals(ref.traceSegmentId) : ref.traceSegmentId != null)
            return false;
        return applicationCode != null ? applicationCode.equals(ref.applicationCode) : ref.applicationCode == null;
    }

    @Override
    public int hashCode() {
        int result = traceSegmentId != null ? traceSegmentId.hashCode() : 0;
        result = 31 * result + (applicationCode != null ? applicationCode.hashCode() : 0);
        return result;
    }
}
