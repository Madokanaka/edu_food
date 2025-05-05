<#import "../layout.ftlh" as layout>
<@layout.layout>
    <h2>Your Cart</h2>

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
                        <td>${item.price} USD</td>
                        <td>
                            <form action="/cart/update" method="post" class="d-inline">
                                <input type="hidden" name="dishId" value="${item.dishId}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <input type="number" name="quantity" value="${item.quantity}" min="1" class="form-control d-inline" style="width: 80px;">
                                <button type="submit" class="btn btn-sm btn-primary">Update</button>
                            </form>
                        </td>
                        <td>${(item.price * item.quantity)?string.currency}</td>
                        <td>
                            <form action="/cart/remove" method="post" class="d-inline">
                                <input type="hidden" name="dishId" value="${item.dishId}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button type="submit" class="btn btn-sm btn-danger">Remove</button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>

        <div class="mt-4">
            <h4>Summary</h4>
            <p><strong>Total Items:</strong> ${totalItems}</p>
            <p><strong>Total Price:</strong> ${totalPrice?string.currency}</p>
            <a href="/checkout" class="btn btn-success">Proceed to Checkout</a>
        </div>
    <#else>
        <div class="alert alert-info" role="alert">
            <i class="fas fa-info-circle me-2"></i>Your cart is empty.
        </div>
    </#if>

    <a href="/restaurants" class="btn btn-secondary mt-3">Continue Shopping</a>
</@layout.layout>