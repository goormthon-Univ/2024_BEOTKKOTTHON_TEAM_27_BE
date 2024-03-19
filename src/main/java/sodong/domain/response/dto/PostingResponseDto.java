package sodong.domain.response.dto;

import java.util.List;

public class PostingResponseDto {
    private boolean isSuccess;
    private int code;
    private String message;
    private List<PostingDto> result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PostingDto> getResult() {
        return result;
    }

    public void setResult(List<PostingDto> result) {
        this.result = result;
    }

    public static class PostingDto {
        private long postingId;
        private int requestCount;

        public long getPostingId() {
            return postingId;
        }

        public void setPostingId(long postingId) {
            this.postingId = postingId;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }
    }
}
