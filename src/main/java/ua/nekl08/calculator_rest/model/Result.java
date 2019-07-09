package ua.nekl08.calculator_rest.model;

public class Result {
    private Long result;

    public Result(Long result) {
        this.result = result;
    }

    public Result() {
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        return this.result.equals(result.result);

    }

    @Override
    public int hashCode() {
        return result.hashCode();
    }
}
