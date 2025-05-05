<#import "../layout.ftlh" as layout>
<@layout.layout>
    <h2>Ваша корзина</h2>

    <#if error??>
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </#if>
    <#if success??>
        <div class="alert alert-success" role="alert">
            ${success}
        </div>
    </#if>

    <#if cart.items?has_content>
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Restaurant</th>
                    <th>Dish</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <#list cart.items as item>
                    <tr>
                        <td>${item.restaurantName}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.price} СОМ</td>
                        <td>
                            <form action="/cart/update" method="post" class="d-inline">
                                <input type="hidden" name="dishId" value="${item.dishId}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control d-inline" style="width: 80px;">
                                <button type="submit" class="btn btn-sm btn-primary">Обновить</button>
                            </form>
                        </td>
                        <td>${(item.price * item.quantity)} СОМ</td>
                        <td>
                            <form action="/cart/remove" method="post" class="d-inline">
                                <input type="hidden" name="dishId" value="${item.dishId}">
                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                                           value="${(_csrf.token)!'csrf-token'}"/>
                                </#if>
                                <button type="submit" class="btn btn-sm btn-danger">Удалить</button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>

        <#if SPRING_SECURITY_CONTEXT??>
            <#assign userPr = SPRING_SECURITY_CONTEXT.authentication.principal>
            <div class="mt-4">
                <h4>Итог</h4>
                <p><strong>Total Items:</strong> ${totalItems}</p>
                <p><strong>Total Price:</strong> ${totalPrice} СОМ</p>
                <form action = "/cart/makeOrder" method="post" class="d-inline">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>
                    <button type="submit" class="btn btn-success">Сделать заказ</button>
                </form>
            </div>
        <#else>
            <div class="alert alert-warning mt-4" role="alert">
                Для продолжения <a href="/auth/login">войдите в аккаунт</a>.
            </div>
        </#if>
    <#else>
        <div class="alert alert-info" role="alert">
            <i class="fas fa-info-circle me-2"></i>Ваша корзина пуста.
        </div>
    </#if>

    <a href="/restaurants" class="btn btn-secondary mt-3">Продолжить покупки</a>
</@layout.layout>