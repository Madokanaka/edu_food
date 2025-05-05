<#import "../layout.ftlh" as layout>
<@layout.layout>
    <div class="row">
        <div class="col-12">
            <h1 class="mb-4">Заказ #${order.id}</h1>
            <div class="card mb-4">
                <div class="card-body">
                    <h5 class="card-title">Детали заказа</h5>
                    <p class="card-text"><strong>Создан:</strong> ${order.createdAt}</p>
                    <p class="card-text"><strong>Сумма:</strong> ${order.totalPrice} СОМ</p>
                </div>
            </div>

            <h2 class="mb-3">Предметы</h2>
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                    <tr>
                        <th>Блюдо</th>
                        <th>Количество</th>
                        <th>Цена</th>
                        <th>Ресторан</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list items as item>
                        <tr>
                            <td>${item.dishName}</td>
                            <td>${item.quantity}</td>
                            <td>${item.price} СОМ</td>
                            <td>${item.restaurantName}</td>
                        </tr>
                    </#list>
                    <#if items?size == 0>
                        <tr>
                            <td colspan="4" class="text-center">No items in this order.</td>
                        </tr>
                    </#if>
                    </tbody>
                </table>
            </div>

            <a href="/profile" class="btn btn-primary mt-3">Профиль</a>
        </div>
    </div>
</@layout.layout>