<#import "../layout.ftlh" as layout>
<@layout.layout>
    <h2>Your Profile</h2>

    <div class="mt-4">
        <h4>Welcome, ${user.email}</h4>
    </div>

    <div class="mt-4">
        <h4>Your Orders</h4>
        <#if orders?has_content>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Total Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list orders as order>
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.createdAt}</td>
                                <td>${order.totalPrice} СОМ</td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        <#else>
            <div class="alert alert-info" role="alert">
                You have no orders yet.
            </div>
        </#if>
    </div>

    <a href="/restaurants" class="btn btn-secondary mt-3">Continue Shopping</a>
</@layout.layout>