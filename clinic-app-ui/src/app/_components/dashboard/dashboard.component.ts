import { Component, OnInit, ViewChild, AfterViewInit } from "@angular/core";
import { AuthenticationService } from "src/app/_services/authentication.service";
import { Route } from "@angular/compiler/src/core";
import { Router } from "@angular/router";
import { PatientService } from "src/app/_services/Patient.service";
import { Patient } from "src/app/_models/patient";
import { SelectionModel } from "@angular/cdk/collections";
import { MatTableDataSource } from "@angular/material/table";
import { MatSort } from "@angular/material/sort";
import { MatPaginator } from "@angular/material/paginator";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.scss"]
})
export class DashboardComponent implements OnInit, AfterViewInit {
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  user = "";
  // dataSource: Patient[];
  displayedColumns = [
    "select",
    "id",
    "ic",
    "name",
    "age",
    "gender",
    "dob",
    "phoneNumber",
    "address",
    "details"
  ];
  dataSource = new MatTableDataSource<Patient>();
  selection = new SelectionModel<Patient>(true, []);

  /** Whether the number of selected elements matches the total number of rows. */
  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  };

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected()
      ? this.selection.clear()
      : this.dataSource.data.forEach(row => this.selection.select(row));
  }

  /** The label for the checkbox on the passed row */
  checkboxLabel(row?: Patient): string {
    if (!row) {
      return `${this.isAllSelected() ? "select" : "deselect"} all`;
    }
    return `${
      this.selection.isSelected(row) ? "deselect" : "select"
    } row ${row.id + 1}`;
  }

  constructor(
    private authService: AuthenticationService,
    private router: Router,
    private patientService: PatientService
  ) {}

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;

    if (this.authService.isUserLoggedIn()) {
      this.user = sessionStorage.getItem("email");
    }
    this.patientService.getAllPatients().subscribe(
      data => {
        this.dataSource.data = data;
        console.log(this.dataSource);
      },
      error => {}
    );
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
  }

  public redirectToDetails = (id: string) => {
    console.log('trigger to view detials with patient id : '+id);
  };

}
