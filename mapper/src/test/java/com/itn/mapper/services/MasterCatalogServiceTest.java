package com.itn.mapper.services;

import com.github.javafaker.Faker;
import com.itn.mapper.dao.MasterCatalogsDao;
import com.itn.mapper.model.Brand;
import com.itn.mapper.model.Category;
import com.itn.mapper.model.Distributor;
import com.itn.mapper.model.MasterCatalogItem;
import com.itn.mapper.service.MasterCatalogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MasterCatalogServiceTest {
    @InjectMocks
    MasterCatalogService masterCatalogService;
    @Mock
    MasterCatalogsDao masterCatalogsDao;

    private Faker faker=new Faker();

    @Test
    public void testAddProduct(){
        when(masterCatalogsDao.saveAll(any(new ArrayList<MasterCatalogItem>().getClass()))).thenReturn(createFakeMCList());
        List<MasterCatalogItem> responseList = masterCatalogService.addProducts(null);
        responseList.forEach(item -> present(item));
    }

    private void present(MasterCatalogItem item) {
        System.out.println("Item %d: " + item.toString());
    }

    private List<MasterCatalogItem> createFakeMCList() {
        List<MasterCatalogItem> returnItems = new ArrayList<>();
        for (int k=0;k<10;k++){
            returnItems.add(MasterCatalogItem.builder()
                    .masterId(new Long(faker.number().numberBetween(10,1000)))
                    .gtin(faker.number().digits(15))
                    .created(new Date())
                    .manufacturerNo(faker.number().digits(10))
                    .productName(faker.superhero().name())
                    .productNo(faker.number().digits(5))
                    .description(faker.ancient().hero())
                    .brand(
                            Brand.builder().brandId(faker.number().numberBetween(10,1000))
                            .brandName(faker.food().ingredient())
                            .build()
                    )
                    .breakLevel(faker.number().numberBetween(10,1000))
                    .category(Category.builder()
                            .categoryId(faker.number().numberBetween(10,1000)+"")
                            .categoryName(faker.lordOfTheRings().location())
                            .build())
                    .distributor(Distributor.builder()
                            .distributorCode(faker.number().numberBetween(10,1000)+"")
                            .distributorName(faker.name().fullName()).build())
                    .build());
        }
        return returnItems;
    }

}
