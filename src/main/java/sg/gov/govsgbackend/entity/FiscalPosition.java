package sg.gov.govsgbackend.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class FiscalPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "year_of_balance")
    private Integer yearOfBalance;

    @NotBlank
    @NotNull
    @Column(name = "actual_revised_estimated")
    private String actualRevisedEstimated;

    @NotBlank(message = "La categoría no puede estar vacía")
    @NotNull
    @Column(name = "category")
    private String category;

    @NotBlank(message = "El item no puede estar vacío")
    @NotNull
    @Column(name = "item")
    private String item;

    @NotNull
    @Column(name = "amount")
    private Integer amount;

    @NotNull
    @Column(name = "percent_of_gdp")
    @Digits(integer = 1, fraction = 4)
    private BigDecimal percentOfGdp;

}
