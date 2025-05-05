<#import "../layout.ftlh" as layout>
<@layout.layout>
    <h2>Restaurants</h2>
    <form class="mb-4" action="/restaurants" method="get">
        <div class="input-group">
            <input type="text" class="form-control" name="search" value="${search!''}" placeholder="Search restaurants by name...">
            <button type="submit" class="btn btn-primary">Search</button>
        </div>
    </form>
    <div class="row">
        <#list restaurants as restaurant>
            <div class="col-md-6 mb-3">
                <div class="card h-100">
                    <#if restaurant.photoName??>
                        <img src="/api/images/${restaurant.photoName}" class="card-img-top" alt="${restaurant.name}" style="width: 100%; height: 200px; object-fit: cover; object-position: center;">                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${restaurant.name}</h5>
                        <p class="card-text">${restaurant.description}</p>
                        <a href="/restaurants/${restaurant.id}" class="btn btn-primary">View Menu</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
    <#if totalPages gt 1>
        <nav aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <#if currentPage?number gt 1>
                    <li class="page-item">
                        <a class="page-link" href="/restaurants?page=${currentPage?number - 1}&search=${search!''}">Previous</a>
                    </li>
                </#if>
                <#list 1..totalPages as pageNum>
                    <li class="page-item <#if pageNum == currentPage?number>active</#if>">
                        <a class="page-link" href="/restaurants?page=${pageNum}&search=${search!''}">${pageNum}</a>
                    </li>
                </#list>
                <#if currentPage?number lt totalPages>
                    <li class="page-item">
                        <a class="page-link" href="/restaurants?page=${currentPage?number + 1}&search=${search!''}">Next</a>
                    </li>
                </#if>
            </ul>
        </nav>
    </#if>
</@layout.layout>