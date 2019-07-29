import { Injectable } from '@angular/core';
import { CanActivate, Router ,ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Route } from '@angular/compiler/src/core';
import { AuthenticationService } from '../_services/authentication.service';
import { Observable } from 'rxjs';

@Injectable()
export class AuthGuard implements CanActivate{
  constructor(private authService: AuthenticationService, private router: Router) { }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      if(this.authService.isUserLoggedIn()) {
        return true;
      }

      this.router.navigate(['/login']);
    // you can save redirect url so after authing we can move them back to the page they requested
    return false;
  }

  }


