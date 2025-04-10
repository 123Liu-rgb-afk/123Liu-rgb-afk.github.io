package com.lrx.entity;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午2:44
 */
public class IdenCard {
    private Integer id;
    private String card_sn;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard_sn() {
        return card_sn;
    }

    public void setCard_sn(String card_sn) {
        this.card_sn = card_sn;
    }

  @Override
  public String toString() {
      return "IdenCard{" +
              "id=" + id +
              ", card_sn='" + card_sn + '\'' +
              ", person=" + person +
              '}';
  }

}
