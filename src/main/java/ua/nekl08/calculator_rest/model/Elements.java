package ua.nekl08.calculator_rest.model;

public class Elements {

    private Long firstElement;

    private Long secondElement;

    public Elements() {}

    public Elements(Long firstElement, Long secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public Long getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(Long firstElement) {
        this.firstElement = firstElement;
    }

    public Long getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(Long secondElement) {
        this.secondElement = secondElement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Elements elements = (Elements) o;

        if (!firstElement.equals(elements.firstElement)) return false;
        return secondElement.equals(elements.secondElement);

    }

    @Override
    public int hashCode() {
        int result = firstElement.hashCode();
        result = 31 * result + secondElement.hashCode();
        return result;
    }
}
