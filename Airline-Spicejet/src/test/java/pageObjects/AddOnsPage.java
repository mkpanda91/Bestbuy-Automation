package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddOnsPage {

	private WebDriver driver;
	Actions act;
	JavascriptExecutor js;
	WebDriverWait wait;

	// Constructor used to initialize the driver & all page objects of Add Ons Page
	public AddOnsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);
	}

	// Locating WebElements on the Add Ons Page
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-f9v2oj r-1pcd2l5 r-lrx3fh']//child::div[@class='css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr']//*[name()='svg']")
	WebElement close_infoPopup;
	@FindBy(xpath = "//div[@class='at_addon_modal']")
	WebElement addOnModal;
	@FindBy(xpath = "//div[@class='at_addon_modal']//div[@class='at_addon_close']//img")
	WebElement close_addOnModal;
	@FindBy(xpath = "//div[@id='tt_pop']")
	WebElement div_popup;
	@FindBy(xpath = "//div[@id='tt_pop']//*[@id='skipfrompopup']")
	WebElement link_skipPopup;

	@FindBy(xpath = "(//div[contains(@data-testid,'spice-max-card-add-cta')])[2]")
	WebElement btn_addForSpmax;
	@FindBy(xpath = "//div[contains(@data-testid,'bookingFlow-seats-add-cta')]")
	WebElement btn_chooseSeat;
	@FindBy(xpath = "css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh r-13qz1uu")
	WebElement div_Seat;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-13ubf1n r-1mnahxq']//*[name()='svg']//*[local-name()='g' and @fill='none']//*[local-name()='path' and contains(@fill,'url(#spiceMaxSeata)')])[2]")
	WebElement select_SpmaxSeat;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-13ubf1n r-1mnahxq']//*[name()='svg']//*[local-name()='g' and @fill='none']//*[local-name()='path' and contains(@fill,'url(#preferredSeata)')])[2]")
	WebElement select_preferredSeat;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-13ubf1n r-1mnahxq']//*[name()='svg']//*[local-name()='g' and @fill='none']//*[local-name()='path' and contains(@fill,'url(#normalSeata)')])[2]")
	WebElement select_normalSeat;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1niwhzg r-1p0dtai r-6koalj r-1d2f490 r-1xcajam r-zchlnj r-ipm5af']//descendant::div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1n9sb9w r-xaggoz r-1jte41z r-nsbfu8']")
	WebElement div_extraComfSeat;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1n9sb9w r-xaggoz r-1jte41z r-nsbfu8']//div[@class='css-1dbjc4n r-173mn98 r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr'])[1]")
	WebElement btn_skipExtraComfSeat;

	@FindBy(xpath = "//span[@class='css-76zvg2 css-16my406 r-homxoj r-poiln3']")
	List<WebElement> txt_List_SelectMealAndSeat;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73']//div")
	WebElement btn_txt_SelectMeals;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement btn_SelectMeal;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-150rngu r-akgwms r-13awgt0 r-eqz5dr r-16y2uox r-1wbh5a2 r-1w45io0 r-11yh6sk r-1rnoaur r-d9fdf6 r-1knelpx r-tvv088 r-1sncvnh r-hnxvie']")
	WebElement div_Meal;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1mlwlqe r-z80fyv r-zso239 r-1udh08x r-19wmn03 r-1lgpqti']//img")
	List<WebElement> chkbox_MealItems;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1mlwlqe r-z80fyv r-zso239 r-1udh08x r-19wmn03 r-1lgpqti']//img)[1]")
	WebElement chkbox_MealItem1;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1mlwlqe r-z80fyv r-zso239 r-1udh08x r-19wmn03 r-1lgpqti']//img)[2]")
	WebElement chkbox_MealItem2;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1777fci r-15d164r r-1n0xq6e r-156q2ks']//div")
	WebElement txt_noMeal;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr']//div//img)[2]")
	WebElement editSeatForReturn;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement btn_Done;
	@FindBy(xpath="//div[contains(@data-testid,'spicePlus-add-cta')]")
	WebElement btn_spicePlus;
	@FindBy(xpath = "//div[contains(@data-testid,'add-ons-continue-footer-button')][3]")
	WebElement btn_Continue;

	// Performing actions on WebElements of the Add Ons Page - One way trip
	public void chooseOnewayTripAddOn(String faretype, String adultCount, String childCount) {
		try {
			int selectionCount = 0;
			int adCount = Integer.parseInt(adultCount);
			int chCount = Integer.parseInt(childCount);
//			// Thread.sleep(5000);
			if (faretype.equalsIgnoreCase("SpiceSaver")) {
				Thread.sleep(5000);
				// Selection of Seat
				if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
					btn_chooseSeat.click();
					while (selectionCount < (adCount + chCount)) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
						try {
							act.moveToElement(select_normalSeat).click().perform();
							Thread.sleep(2000);
							if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
								selectionCount++;
							} else {
								btn_skipExtraComfSeat.click();
								selectionCount++;
							}
						} catch (TimeoutException e) {
							btn_skipExtraComfSeat.click();
							selectionCount++;
							while (selectionCount < (adCount + chCount)) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
								act.moveToElement(select_normalSeat).click().perform();
								selectionCount++;
							}
						}
					}
					btn_Done.click();
				} else {
					close_addOnModal.click();
					if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
							|| faretype.equalsIgnoreCase("SpiceMax")) {
						chooseOnewayTripAddOn(faretype, adultCount, childCount);
					}
				}
			}

			else if (faretype.equalsIgnoreCase("SpiceFlex")) {
				Thread.sleep(5000);
				close_infoPopup.click();
				// Selection of Seat
				if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
					js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
					btn_chooseSeat.click();
					while (selectionCount < (adCount + chCount)) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
						try {
							act.moveToElement(select_SpmaxSeat).click().perform();
							Thread.sleep(2000);
							if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
								selectionCount++;
							} else {
								btn_skipExtraComfSeat.click();
								selectionCount++;
							}
						} catch (TimeoutException e) {
							btn_skipExtraComfSeat.click();
							selectionCount++;
							while (selectionCount < (adCount + chCount)) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
								act.moveToElement(select_SpmaxSeat).click().perform();
								selectionCount++;
							}
						}
					}

					// Selection of Meal
					if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
						btn_SelectMeal.click();
					wait.until(ExpectedConditions.visibilityOf(div_Meal));
					for (selectionCount = 0; selectionCount < (adCount + chCount); selectionCount++) {
						if (chkbox_MealItems.size() > 0) {
							js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
							if (selectionCount % 2 == 0) {
								chkbox_MealItem1.click();
								Thread.sleep(2000);
							} else {
								chkbox_MealItem2.click();
							}
						} else {
							btn_Done.click();
							return;
						}
					}
					btn_Done.click();
				} else {
					close_addOnModal.click();
					if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
							|| faretype.equalsIgnoreCase("SpiceMax")) {
						chooseOnewayTripAddOn(faretype, adultCount, childCount);
					}
				}
			}

			else if (faretype.equalsIgnoreCase("SpiceMax")) {
				Thread.sleep(5000);
				// Selection of Seat
				if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
					while (selectionCount < 2 * (adCount + chCount)) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
						try {
							act.moveToElement(select_SpmaxSeat).click().perform();
							Thread.sleep(2000);
							if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
								selectionCount++;
							} else {
								btn_skipExtraComfSeat.click();
								selectionCount++;
							}
						} catch (TimeoutException e) {
							btn_skipExtraComfSeat.click();
							selectionCount++;
							while (selectionCount < (adCount + chCount)) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
								act.moveToElement(select_SpmaxSeat).click().perform();
								selectionCount++;
							}
						}
					}
					if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
						btn_SelectMeal.click();
					wait.until(ExpectedConditions.visibilityOf(div_Meal));
					for (selectionCount = 0; selectionCount < 2 * (adCount + chCount); selectionCount++) {
						if (chkbox_MealItems.size() > 0) {
							js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
							if (selectionCount % 2 == 0) {
								chkbox_MealItem1.click();
								Thread.sleep(2000);
							} else {
								chkbox_MealItem2.click();
								Thread.sleep(2000);
							}
						} else {
							btn_Done.click();
							return;
						}
					}
					btn_Done.click();
				} else {
					close_addOnModal.click();
					if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
							|| faretype.equalsIgnoreCase("SpiceMax")) {
						chooseOnewayTripAddOn(faretype, adultCount, childCount);
					}
				}
			}

			else {
				System.out.println(faretype + " provided is an invalid option.");
				return;
			}
		} catch (ElementNotInteractableException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	// Performing actions on WebElements of the Add Ons Page - Two way trip
	public void chooseTwowayTripAddOn(String deptfaretype, String retfaretype, String adultCount, String childCount) {
		try {
			int selectionCount = 0;
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			int adCount = Integer.parseInt(adultCount);
			int chCount = Integer.parseInt(childCount);
			// Thread.sleep(7000);

			// **** The below block executes when faretype of both leg of journey is same in
			// a round trip ****
			if (deptfaretype.equalsIgnoreCase(retfaretype)) {
				String faretype = deptfaretype;

				// for faretype journey of SpiceSaver
				if (faretype.equalsIgnoreCase("SpiceSaver")) {
					Thread.sleep(5000);
					// Selection of Seat
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						while (selectionCount < 2 * (adCount + chCount)) {
							js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
							try {
								act.moveToElement(select_normalSeat).click().perform();
								Thread.sleep(2000);
								if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
									selectionCount++;
								} else {
									btn_skipExtraComfSeat.click();
									selectionCount++;
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < (adCount + chCount)) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
									act.moveToElement(select_normalSeat).click().perform();
									selectionCount++;
								}
							}
						}
//						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
//							btn_SelectMeal.click();
//						wait.until(ExpectedConditions.visibilityOf(div_Meal));
//						for (selectionCount = 0; selectionCount < 2 * (adCount + chCount); selectionCount++) {
//							if (chkbox_MealItems.size() > 0) {
//								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
//								if (selectionCount % 2 == 0) {
//									chkbox_MealItem1.click();
//									Thread.sleep(2000);
//								} else {
//									chkbox_MealItem2.click();
//								}
//							} else {
//								btn_Done.click();
//								return;
//							}
//						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
								|| faretype.equalsIgnoreCase("SpiceMax")) {
							chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
						}
					}
				}

				// for faretype journey of SpiceFlex
				else if (faretype.equalsIgnoreCase("SpiceFlex")) {
					Thread.sleep(5000);
					close_infoPopup.click();
					// Selection of Seat
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						while (selectionCount < 2 * (adCount + chCount)) {
							js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
							try {
								act.moveToElement(select_SpmaxSeat).click().perform();
								Thread.sleep(2000);
								if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
									selectionCount++;
								} else {
									btn_skipExtraComfSeat.click();
									selectionCount++;
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < (adCount + chCount)) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
									act.moveToElement(select_SpmaxSeat).click().perform();
									selectionCount++;
								}
							}
						}

						// Selection of Meal
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < 2 * (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
								|| faretype.equalsIgnoreCase("SpiceMax")) {
							chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
						}
					}
				}

				// for faretype journey of SpiceMax
				if (faretype.equalsIgnoreCase("SpiceMax")) {
					Thread.sleep(5000);
					// Selection of Seat
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						while (selectionCount < 2 * (adCount + chCount)) {
							js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
							try {
								act.moveToElement(select_SpmaxSeat).click().perform();
								Thread.sleep(2000);
								if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
									selectionCount++;
								} else {
									btn_skipExtraComfSeat.click();
									selectionCount++;
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < (adCount + chCount)) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
									act.moveToElement(select_SpmaxSeat).click().perform();
									selectionCount++;
								}
							}
						}
						// Selection of Meal
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < 2 * (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
									Thread.sleep(2000);
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						if (faretype.equalsIgnoreCase("SpiceSaver") || faretype.equalsIgnoreCase("SpiceFlex")
								|| faretype.equalsIgnoreCase("SpiceMax")) {
							chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
						}
					}
				}
			}

			// **** The below block executes when faretype of both leg of journey is
			// different in a round trip ****
			else if (!deptfaretype.equalsIgnoreCase(retfaretype)) {
				int seatTypeCounter;

				// Combination 1
				if ((deptfaretype.equalsIgnoreCase("Spicesaver") && retfaretype.equalsIgnoreCase("Spiceflex"))
						|| (deptfaretype.equalsIgnoreCase("Spicesaver") && retfaretype.equalsIgnoreCase("Spicemax"))) {
					Thread.sleep(5000);
					if ((deptfaretype.equalsIgnoreCase("Spiceflex")) || (retfaretype.equalsIgnoreCase("Spiceflex")))
						close_infoPopup.click();
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						seatTypeCounter = 0;
						while (selectionCount < 2 * (adCount + chCount)) {
							seatTypeCounter++;
							try {
								if (seatTypeCounter <= 2) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
									act.moveToElement(select_normalSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								} else {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
									act.moveToElement(select_SpmaxSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < 2 * (adCount + chCount)) {
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
										act.moveToElement(select_SpmaxSeat).click().perform();
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							}
						}
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
					}
				}

				// Combination 2
				else if (deptfaretype.equalsIgnoreCase("Spiceflex") && retfaretype.equalsIgnoreCase("Spicesaver")) {
					Thread.sleep(5000);
					if ((deptfaretype.equalsIgnoreCase("Spiceflex")) || (retfaretype.equalsIgnoreCase("Spiceflex")))
						close_infoPopup.click();
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						seatTypeCounter = 0;
						while (selectionCount < 2 * (adCount + chCount)) {
							seatTypeCounter++;
							try {
								if (seatTypeCounter <= 2) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
									act.moveToElement(select_SpmaxSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								} else {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
									act.moveToElement(select_normalSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < 2 * (adCount + chCount)) {
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
										act.moveToElement(select_SpmaxSeat).click().perform();
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							}
						}
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
						// System.out.println("Seat selection couldn't be completed. Please retry.");
					}
				}

				// Combination 3
				if ((deptfaretype.equalsIgnoreCase("Spiceflex") && retfaretype.equalsIgnoreCase("Spicemax"))
						|| (deptfaretype.equalsIgnoreCase("Spicemax") && retfaretype.equalsIgnoreCase("Spiceflex"))) {
					Thread.sleep(5000);
					if ((deptfaretype.equalsIgnoreCase("Spiceflex")) || (retfaretype.equalsIgnoreCase("Spiceflex")))
						close_infoPopup.click();
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						while (selectionCount < 2 * (adCount + chCount)) {
							try {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
								act.moveToElement(select_SpmaxSeat).click().perform();
								Thread.sleep(2000);
								if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
									selectionCount++;
								} else {
									btn_skipExtraComfSeat.click();
									selectionCount++;
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < 2 * (adCount + chCount)) {
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
										act.moveToElement(select_SpmaxSeat).click().perform();
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							}
						}
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < 2 * (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
					}
				}

				// Combination 4
				else if (deptfaretype.equalsIgnoreCase("Spicemax") && retfaretype.equalsIgnoreCase("Spicesaver")) {
					Thread.sleep(5000);
					if (wait.until(ExpectedConditions.invisibilityOf(addOnModal))) {
						js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_chooseSeat);
						btn_chooseSeat.click();
						seatTypeCounter = 0;
						while (selectionCount < 2 * (adCount + chCount)) {
							seatTypeCounter++;
							try {
								if (seatTypeCounter <= 2) {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
									act.moveToElement(select_SpmaxSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								} else {
									js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_normalSeat);
									act.moveToElement(select_normalSeat).click().perform();
									Thread.sleep(2000);
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							} catch (TimeoutException e) {
								btn_skipExtraComfSeat.click();
								selectionCount++;
								while (selectionCount < 2 * (adCount + chCount)) {
									if (wait.until(ExpectedConditions.invisibilityOf(div_extraComfSeat))) {
										js.executeScript("arguments[0].scrollIntoViewIfNeeded();", select_SpmaxSeat);
										act.moveToElement(select_SpmaxSeat).click().perform();
										selectionCount++;
									} else {
										btn_skipExtraComfSeat.click();
										selectionCount++;
									}
								}
							}
						}
						if (wait.until(ExpectedConditions.textToBePresentInElement(btn_SelectMeal, "Select Meals")))
							btn_SelectMeal.click();
						wait.until(ExpectedConditions.visibilityOf(div_Meal));
						for (selectionCount = 0; selectionCount < (adCount + chCount); selectionCount++) {
							if (chkbox_MealItems.size() > 0) {
								js.executeScript("arguments[0].scrollIntoViewIfNeeded();", chkbox_MealItems.get(0));
								if (selectionCount % 2 == 0) {
									chkbox_MealItem1.click();
									Thread.sleep(2000);
								} else {
									chkbox_MealItem2.click();
								}
							} else {
								btn_Done.click();
								return;
							}
						}
						btn_Done.click();
					} else {
						close_addOnModal.click();
						chooseTwowayTripAddOn(deptfaretype, retfaretype, adultCount, childCount);
					}
				}

				else
					System.out
							.println("Faretype is incorrect for onward/return journey. Please check and retry later.");
			}

		} catch (ElementNotInteractableException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void clickContinue() {
		js.executeScript("arguments[0].scrollIntoViewIfNeeded();", btn_spicePlus);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		btn_Continue.click();
	}

}
