<#import "../layout.ftlh" as layout>
<@layout.layout>
    <h2>Профиль</h2>


    <div class="mt-4">
        <h4>Ваши заказы</h4>
        <#if orders?has_content>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                    <tr>
                        <th>ID заказа</th>
                        <th>Время</th>
                        <th>Сумма</th>
                        <th>Подробности</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orders as order>
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.createdAt}</td>
                            <td>${order.totalPrice} СОМ</td>
                            <td>
                                <a href="/orders/${order.id}" class="btn btn-sm btn-outline-primary">Детали</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <div class="alert alert-info" role="alert">
                У вас еще нет заказов.
            </div>
        </#if>
    </div>

    <a href="/restaurants" class="btn btn-secondary mt-3">Обратно к покупкам</a>
</@layout.layout>