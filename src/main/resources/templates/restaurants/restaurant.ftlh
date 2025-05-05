<#import "../layout.ftlh" as layout>
<@layout.layout>
    <style>
        .alert {
            background-color: #7bac6d;
            border-color: #579e53;
            color: #178007;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
    </style>
    <h2>${restaurant.name}</h2>
    <p>${restaurant.description}</p>
    <#if restaurant.photoName??>
        <img src="/api/images/${restaurant.photoName}" alt="${restaurant.name}" class="img-fluid mb-4"
             style="max-height: 300px;">
    </#if>

    <h3>Menu</h3>

    <#if success??>
        <div class="alert" role="alert">
            <i class="fas fa-exclamation-circle me-2"></i>${success}
        </div>
    </#if>

    <#if dishes?has_content>

        <div class="row">
            <#list dishes as dish>
                <div class="col-md-6 mb-3">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">${dish.name}</h5>
                            <p class="card-text">${dish.description}</p>
                            <p class="card-text"><strong>Price:</strong> ${dish.price} СОМ</p>
                            <form action="/cart/add" method="post">
                                <input type="hidden" name="dishId" value="${dish.id}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="input-group mb-3">
                                    <input type="number" name="quantity" class="form-control" value="1" min="1"
                                           style="max-width: 100px;">
                                    <button type="submit" class="btn btn-primary">Add to Cart</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    <#else>
        <div class="alert alert-warning fade-in" role="alert">
            <i class="fas fa-exclamation-circle me-2"></i>У ресторана нет блюд.
        </div>
    </#if>

    <#if totalPages gt 1>
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <#if currentPage?number gt 1>
                    <li class="page-item">
                        <a class="page-link" href="/restaurants/${restaurant.id}?page=${currentPage?number - 1}">Previous</a>
                    </li>
                </#if>
                <#list 1..totalPages as pageNum>
                    <li class="page-item <#if pageNum == currentPage?number>active</#if>">
                        <a class="page-link" href="/restaurants/${restaurant.id}?page=${pageNum}">${pageNum}</a>
                    </li>
                </#list>
                <#if currentPage?number lt totalPages>
                    <li class="page-item">
                        <a class="page-link"
                           href="/restaurants/${restaurant.id}?page=${currentPage?number + 1}">Next</a>
                    </li>
                </#if>
            </ul>
        </nav>
    </#if>
</@layout.layout>