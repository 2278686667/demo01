package com.zhby.easyexcel_test.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.merge.OnceAbsoluteMergeStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Test01
 * @Description:
 * @Author: CHB
 * @Date: 2023/5/19 16:58
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date announcementTime = dateFormat.parse("2022/6/28 9:30:10");
        Date bidOpeningTime = dateFormat.parse("2022/6/28 9:30:10");
        Date evaluationStartTime = dateFormat.parse("2022/08/04 14:00:00");
        Date evaluationEndTime = dateFormat.parse("2022/08/04 16:32:02");

        // 创建数据集合
        List<Project> userList = new ArrayList<>();
        userList.add(new Project(
                "WXXS202204003-X09",
                "2022年街道老旧小区改造工程 \n" +
                        "234",
                "WXXS202204003",
                "监理二标段",
                new BigDecimal("18000000"),
                new BigDecimal("18000000"),
                "唐山市行政审批局",
                "18632599896",
                "唐山市政府采购中心",
                "孙梅 0315-5398256",
                "史非凡",
                "0315-5398278",
                "街道老旧小区改造",
                "合同签订生效后12个月。（平台系统上线，申请初步验收；平台系统完成招投标要求的建设内容，申请最终验收，项目服务期限为合同签订生效后12个月）\n本项目不接受联合体投标",
                "1、满足《中华人民共和国政府采购法》第二十二条规定；\n2、落实政府采购政策需满足的资格要求：\n该项目非专门面向中小企业或小型、微型企业采购。落实中小微企业、监狱企业、残疾人福利性单位采购政策。\n3、本项目的特定资格要求：\n无",
                announcementTime,
                bidOpeningTime,
                "唐山市公共资源交易中心不见面开标室-主持台1",
                new BigDecimal("1586800"),
                "",
                "",
                evaluationStartTime,
                evaluationEndTime,
                "公共资源交易中心",
                "评定分离",
                new BigDecimal("0"),
                "",
                "",
                new BigDecimal("0"),
                "王文卫",
                "项目负责人",
                "1322011201301313",
                "130210199202091422",
                "总监有在监项目。",
                "刘月芹。",
                "河北乾为信息科技股份有限公司",
                true,
                "",
                "鸿成工程项目管理有限公司",
                new BigDecimal("1586800"),
                new BigDecimal("49.99"),
                new BigDecimal("15.63"),
                new BigDecimal("32"),
                new BigDecimal("0"),
                new BigDecimal("97.62"),
                1,
                "鸿成工程项目管理有限公司.pdf",
                "张",
                "130123"));

        // 设置导出的文件路径和文件名
        String filePath = "C:/Users/Admin/Desktop/test03.xlsx";
        OnceAbsoluteMergeStrategy onceAbsoluteMergeStrategy = new OnceAbsoluteMergeStrategy(1, 2, 1, 1);
        EasyExcel.write(filePath,Project.class).registerWriteHandler(onceAbsoluteMergeStrategy).sheet("模版").doWrite(userList);


    }

    // 定义数据实体类
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Project{
        @ExcelProperty("项目编号")
        private String projectCode;

        @ExcelProperty("项目名称")
        private String projectName;

        @ExcelProperty("标段编号")
        @ContentLoopMerge
        private String sectionCode;

        @ExcelProperty("标段名称")
        private String sectionName;

        @ExcelProperty("预算金额（元）")
        private BigDecimal budgetAmount;

        @ExcelProperty("最高限价（元）")
        private BigDecimal highestPrice;

        @ExcelProperty("采购人")
        private String purchaser;

        @ExcelProperty("采购人联系方式")
        private String purchaserContact;

        @ExcelProperty("代理机构名称")
        private String agencyName;

        @ExcelProperty("代理机构联系方式")
        private String agencyContact;

        @ExcelProperty("项目联系人")
        private String projectContact;

        @ExcelProperty("项目联系人电话")
        private String projectContactPhone;

        @ExcelProperty("采购需求")
        private String procurementDemand;

        @ExcelProperty("合同履行期限")
        private String contractPerformancePeriod;

        @ExcelProperty("申请人资格要求")
        private String qualificationRequirements;

        @ExcelProperty("公告时间")
        private Date announcementTime;

        @ExcelProperty("开标时间")
        private Date bidOpeningTime;

        @ExcelProperty("开标地点")
        private String bidOpeningLocation;

        @ExcelProperty("投标报价")
        private BigDecimal bidQuote;

        @ExcelProperty("统一社会信用代码")
        private String unifiedSocialCreditCode;

        @ExcelProperty("文件创建标识码")
        private String fileCreateCode;

        @ExcelProperty("评标开始时间")
        private Date evaluationStartTime;

        @ExcelProperty("评标结束时间")
        private Date evaluationEndTime;

        @ExcelProperty("评标地点")
        private String evaluationLocation;

        @ExcelProperty("评标方式")
        private String evaluationMethod;

        @ExcelProperty("招标控制价(元)")
        private BigDecimal tenderControlPrice;

        @ExcelProperty("中标单位")
        private String winningBidder;

        @ExcelProperty("中标人代码")
        private String winningBidderCode;

        @ExcelProperty("中标价格(人民币)")
        private BigDecimal winningBidPrice;

        @ExcelProperty("成员名称")
        private String memberName;

        @ExcelProperty("岗位职责")
        private String jobResponsibility;

        @ExcelProperty("上岗证证号")
        private String workPermitNumber;

        @ExcelProperty("身份证号")
        private String idCardNumber;

        @ExcelProperty("废标原因")
        private String abandonedReason;

        @ExcelProperty("评标组组长")
        private String evaluationGroupLeader;

        @ExcelProperty("投标单位")
        private String biddingUnit;

        @ExcelProperty("是否通过")
        private boolean pass;

        @ExcelProperty("未通过资格审查原因")
        private String failedReason;

        @ExcelProperty("单位名称")
        private String companyName;

        @ExcelProperty("最终报价(元)")
        private BigDecimal finalQuote;

        @ExcelProperty("商务分")
        private BigDecimal businessScore;

        @ExcelProperty("技术分")
        private BigDecimal technicalScore;

        @ExcelProperty("综合分")
        private BigDecimal comprehensiveScore;

        @ExcelProperty("其他分")
        private BigDecimal otherScore;

        @ExcelProperty("汇总分")
        private BigDecimal summaryScore;

        @ExcelProperty("排名")
        private int ranking;

        @ExcelProperty("标书名称")
        private String bidName;

        @ExcelProperty("企业法人")
        private String legalPerson;

        @ExcelProperty("法人证件号码")
        private String legalPersonIdCardNumber;

    }

}
