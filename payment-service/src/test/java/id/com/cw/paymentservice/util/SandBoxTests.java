package id.com.cw.paymentservice.util;

import id.com.cw.paymentservice.model.dto.DataList;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SandBoxTests {

    @InjectMocks
    private SandBox sandBox;

    @SneakyThrows
    @Test
    void test() {
        long startTime = System.currentTimeMillis();
        List<DataList> dataList = new ArrayList<DataList>();

        for (int i = 1; i < 20000; i++) {
            DataList insertData = DataList.builder()
                    .var1(String.valueOf(UUID.randomUUID()))
                    .var2(String.valueOf(UUID.randomUUID()))
                    .var3(String.valueOf(UUID.randomUUID()))
                    .var4(String.valueOf(UUID.randomUUID()))
                    .var5(String.valueOf(UUID.randomUUID()))
                    .var6(String.valueOf(UUID.randomUUID()))
                    .var7(String.valueOf(UUID.randomUUID()))
                    .var8(String.valueOf(UUID.randomUUID()))
                    .var9(String.valueOf(UUID.randomUUID()))
                    .var0(String.valueOf(UUID.randomUUID()))
                    .build();
            dataList.add(insertData);
        }

        SandBox.createExcel(dataList);

        long endDate = System.currentTimeMillis();
        System.out.println("Time elapsed = " + (endDate - startTime)/1000 + " Seconds");
    }

    @Test
    void testObject(){
        DataList dataList = new DataList();
        DataList dataList1 = null;
        System.out.println(ObjectUtils.isEmpty(dataList));
        System.out.println(Objects.isNull(dataList1));
    }

    @Test
    void testObject2(){
        DataList dataList = DataList.builder()
                .var0("test")
                .build();
        DataList dataList1 = null;
        String data = dataList.getVar0();
        System.out.println(dataList.getVar0());
        System.out.println(data);
        System.out.println(dataList.getVar0());
    }
    
}
