package io.swagger.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Readings")
public class ReadingDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    [IndexT3] [bigint] IDENTITY(1,1) NOT NULL,
	[PersonIDT3] [bigint] NULL,
            [DateT3] [nvarchar](50) NULL,
            [DayT3] [nvarchar](50) NULL,
            [INB4BedT1] [int] NULL,
            [T1] [nvarchar](50) NULL,
            [SugAtFastT22] [int] NULL,
            [T2] [nvarchar](50) NULL,
            [MorInB4T3] [int] NULL,
            [T3] [nvarchar](50) NULL,
            [MorInAftT4] [int] NULL,
            [T4] [nvarchar](50) NULL,
            [MorPlace] [nvarchar](50) NULL,
            [MorSugB4T5] [int] NULL,
            [T5] [nvarchar](50) NULL,
            [MorSugAftT6] [int] NULL,
            [T6] [nvarchar](50) NULL,
            [AftInB4T7] [int] NULL,
            [T7] [nvarchar](50) NULL,
            [AftInAftT8] [int] NULL,
            [T8] [nvarchar](50) NULL,
            [AftPlace] [nvarchar](50) NULL,
            [AftSugB4T9] [int] NULL,
            [T9] [nvarchar](50) NULL,
            [AftSugAftT10] [int] NULL,
            [T10] [nvarchar](50) NULL,
            [EveInB4T11] [int] NULL,
            [T11] [nvarchar](50) NULL,
            [EveInAftT12] [int] NULL,
            [T12] [nvarchar](50) NULL,
            [EvnPlace] [nvarchar](50) NULL,
            [EnvSugB4T13] [int] NULL,
            [T13] [nvarchar](50) NULL,
            [EvnSugAftT14] [int] NULL,
            [T14] [nvarchar](50) NULL,
            [Comment] [nvarchar](max) NULL,
}
